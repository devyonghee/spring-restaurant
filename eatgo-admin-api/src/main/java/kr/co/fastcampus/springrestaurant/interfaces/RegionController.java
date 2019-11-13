package kr.co.fastcampus.springrestaurant.interfaces;

import kr.co.fastcampus.springrestaurant.application.RegionService;
import kr.co.fastcampus.springrestaurant.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/regions")
    public List<Region> list() {
        return this.regionService.getRegions();
    }

    @PostMapping("/regions")
    public ResponseEntity create(@RequestBody Region resource) throws URISyntaxException {
        Region region = regionService.addRegion(resource.getName());
        String url = "regions/" + region.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
    }
}
