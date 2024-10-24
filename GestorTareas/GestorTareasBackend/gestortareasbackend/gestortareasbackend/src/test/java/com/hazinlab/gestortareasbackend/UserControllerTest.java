package com.hazinlab.gestortareasbackend;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.hazinlab.gestortareasbackend.controller.UserController;
import com.hazinlab.gestortareasbackend.model.User;
import com.hazinlab.gestortareasbackend.model.UserDTO;
import com.hazinlab.gestortareasbackend.service.UserService;
import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {

  private MockMvc mockMvc;

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController userController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
  }

  @Test
  public void testObtenerUsuarios() throws Exception {
    User user1 = new User("user1", "password1");
    User user2 = new User("user2", "password2");
    when(userService.findAll()).thenReturn(Arrays.asList(user1, user2));

    mockMvc
      .perform(get("/api/users/all"))
      .andExpect(status().isOk())
      .andExpect(
        content()
          .json(
            "[{\"name\":\"user1\",\"pwd\":\"password1\"},{\"name\":\"user2\",\"pwd\":\"password2\"}]"
          )
      );
  }

  @Test
  public void testObtenerUsuario() throws Exception {
    User user = new User("user1", "password1");
    when(userService.findUser("1")).thenReturn(user);

    mockMvc
      .perform(get("/api/users/1"))
      .andExpect(status().isOk())
      .andExpect(content().json("{\"name\":\"user1\",\"pwd\":\"password1\"}"));
  }

  @Test
  public void testCreateUser() throws Exception {
    UserDTO userDTO = new UserDTO();
    userDTO.setName("user1");
    userDTO.setPwd("password1");

    User user = new User(userDTO.getName(), userDTO.getPwd());
    when(userService.addUser(any(User.class))).thenReturn(user);

    mockMvc
      .perform(
        post("/api/users/")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"name\":\"user1\",\"pwd\":\"password1\"}")
      )
      .andExpect(status().isOk())
      .andExpect(content().json("{\"name\":\"user1\",\"pwd\":\"password1\"}"));
  }

  @Test
  public void testVerificateLogin() throws Exception {
    UserDTO userDTO = new UserDTO();
    userDTO.setName("user1");
    userDTO.setPwd("password1");

    User user = new User(userDTO.getName(), userDTO.getPwd());
    when(userService.findByNameAndPwd(user.getName(), user.getPwd()))
      .thenReturn(Optional.of(user));

    mockMvc
      .perform(
        post("/api/users/verification")
          .contentType(MediaType.APPLICATION_JSON)
          .content("{\"name\":\"user1\",\"pwd\":\"password1\"}")
      )
      .andExpect(status().isOk())
      .andExpect(content().json("{\"name\":\"user1\",\"pwd\":\"password1\"}"));
  }
}
