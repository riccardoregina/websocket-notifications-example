package it.unina.notification_example.adapter.in;

import it.unina.notification_example.port.in.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/listings")
public class Controller {
    @Autowired
    private ListingService listingService;

    @PostMapping
    public ResponseEntity<Void> createListing(@RequestBody String title) {
        listingService.createListing(title);
        return ResponseEntity.ok().build();
    }
}
