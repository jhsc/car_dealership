package com.jhsc.car_dealership.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
public class CarsControllerTest {
  @Autowired
  private CarController controller;

  @Autowired
  private MockMvc mvc;

  @Test
  void whenRootEndpoint_thenSuccess() {
    String response = controller.home();

    assertEquals("hello from spring Boot", response);
  }

  @Test
  void whenCarsEndpointGetAll_thenSuccess() throws Exception {
    RequestBuilder req = MockMvcRequestBuilders.get("/cars");
    MvcResult result = mvc.perform(req).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  void whenCarsEndpointGetByColorRed_thenSuccess() throws Exception {
    RequestBuilder req = MockMvcRequestBuilders.get("/cars").param("color", "Red");
    mvc.perform(req).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0]._id").exists());
  }

  @Test
  void whenCarsEndpointGetByAllPossibleFilters_thenSuccess() throws Exception {
    RequestBuilder req = MockMvcRequestBuilders.get("/cars").param("color", "White").param("sun_roof", "false")
        .param("four_wheel_drive", "false").param("low_miles", "true").param("power_windows", "false")
        .param("navigation", "false").param("heated_seats", "true");
    mvc.perform(req).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$[0]._id").exists());
  }

  @Test
  void whenCarsEndpointReturnEmpty_thenSuccess() throws Exception {
    RequestBuilder req = MockMvcRequestBuilders.get("/cars").param("color", "Green");
    mvc.perform(req).andDo(print()).andExpect(status().isNoContent()).andExpect(jsonPath("$[0]._id").doesNotExist());
  }

}
