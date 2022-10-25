package com.zmo.familydb.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.zmo.familydb.dto.CityDto;
import com.zmo.familydb.exception.RecordNotFoundException;
import com.zmo.familydb.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

/*
With these annotations, spring create call to the real DB.
@SpringBootTest
@AutoConfigureMockMvc
 */

@WebMvcTest(controllers = CityController.class)
class CityControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    CityService cityService;

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        CityDto city = new CityDto(1, "NameOfTheCity");

        when(cityService.getCityById(eq(1))).thenReturn(Optional.of(city));

        this.mockMvc.perform(get("/family_db/v1/city/{cityId}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("cityId").value(1))
                .andExpect(jsonPath("cityName").value("NameOfTheCity"))
                .andDo(print());
    }

    @Test
    void assertStatusNotFoundWhenNotExists() throws Exception {
        when(cityService.getCityById(eq(1))).thenThrow(RecordNotFoundException.class);

        this.mockMvc.perform(get("/family_db/v1/city/{cityId}", 1))
                .andExpect(status().isNotFound())
                .andExpect(header().string("message-header", "No city with ID: 1"))
                .andDo(print());
    }
}