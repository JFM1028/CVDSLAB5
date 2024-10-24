package com.hazinlab;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.hazinlab.gestortareasbackend.model.User;
import com.hazinlab.gestortareasbackend.repository.UserRepository;
import com.hazinlab.gestortareasbackend.service.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testFindUser() {
    User user = new User();
    user.setId("1");
    when(userRepository.findById("1")).thenReturn(Optional.of(user));

    User result = userService.findUser("1");
    assertNotNull(result);
    assertEquals("1", result.getId());
  }

  @Test
  public void testAddUser() {
    User user = new User();
    user.setId("1");
    when(userRepository.save(user)).thenReturn(user);

    User result = userService.addUser(user);
    assertNotNull(result);
    assertEquals("1", result.getId());
  }

  @Test
  public void testFindAll() {
    User user1 = new User();
    user1.setId("1");
    User user2 = new User();
    user2.setId("2");
    List<User> users = Arrays.asList(user1, user2);
    when(userRepository.findAll()).thenReturn(users);

    List<User> result = userService.findAll();
    assertNotNull(result);
    assertEquals(2, result.size());
  }

  @Test
  public void testFindByNameAndPwd() {
    User user = new User();
    user.setName("test");
    user.setPwd("password");
    when(userRepository.findByNameAndPwd("test", "password"))
      .thenReturn(Optional.of(user));

    Optional<User> result = userService.findByNameAndPwd("test", "password");
    assertTrue(result.isPresent());
    assertEquals("test", result.get().getName());
  }
}
