package kr.co.fastcampus.springrestaurant.application;

import kr.co.fastcampus.springrestaurant.domain.Region;
import kr.co.fastcampus.springrestaurant.domain.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class RegionServiceTest {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.regionService = new RegionService(regionRepository);
    }

    @Test
    void getRegions() {
        ArrayList<Region> mockRegions = new ArrayList<>();
        mockRegions.add(Region.builder().name("Seoul").build());
        given(regionRepository.findAll()).willReturn(mockRegions);

        List<Region> regions = regionService.getRegions();
        Region region = regions.get(0);
        assertThat(region.getName()).isEqualTo("Seoul");
    }

    @Test
    void addRegion() {
        Region region = regionService.addRegion("Seoul");
        verify(regionRepository).save(any());
        assertThat(region.getName()).isEqualTo("Seoul");
    }

}