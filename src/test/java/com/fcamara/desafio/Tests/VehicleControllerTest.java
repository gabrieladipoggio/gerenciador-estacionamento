package com.fcamara.desafio.Tests;

import com.fcamara.desafio.DesafioApplication;
import com.fcamara.desafio.Model.Vehicle;
import com.fcamara.desafio.Repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VehicleRepository vehicleRepository;

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

        mockMvc.perform(get("/vehicle"))
                .andExpect(jsonPath("$[0].registration").value("OVJ-2910"));

    }

    @Test
    public void handlesVehicleNotRegisteredException() throws Exception{
        Vehicle vehicle = new Vehicle();
        vehicle.setColor("White");
        vehicle.setMake("Mustang");
        vehicle.setModel("GT500");
        vehicle.setRegistration("123-ABC");
        vehicle.setType(Vehicle.TypeOfVehicle.CAR);
        vehicleRepository.save(vehicle);

        mockMvc
                .perform(patch("/removeFromGarage?registration=1&companyId=999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void vehicleShouldBeACarOrMotorcycle()throws Exception {
        mockMvc
                .perform(post("/vehicle")
                .content("{\n" +
                        "  \"color\": \"Red\",\n" +
                        "  \"make\": \"Ford\",\n" +
                        "  \"model\": \"Fiesta\",\n" +
                        "  \"registration\": \"OVJ-2910\",\n" +
                        "  \"type\": \"TEAPOT\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
