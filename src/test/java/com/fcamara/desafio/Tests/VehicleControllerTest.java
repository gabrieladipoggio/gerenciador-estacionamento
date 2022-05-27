package com.fcamara.desafio.Tests;

import com.fcamara.desafio.DesafioApplication;
import com.fcamara.desafio.Model.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldCreateVehicleAndSaveIt() throws Exception{
        mockMvc.perform(post("/vehicle")
                .content("{\n" +
                        "  \"color\": \"Red\",\n" +
                        "  \"make\": \"Ford\",\n" +
                        "  \"model\": \"Fiesta\",\n" +
                        "  \"registration\": \"OVJ-2910\",\n" +
                        "  \"type\": \"CAR\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        Vehicle expectedVehicle = new Vehicle();
        mockMvc.perform(get("/vehicle"))
                .andExpect(jsonPath("$[0].registration").value("OVJ-2910"));

    }

}
