package it.unina.notification_example.port.in;

import it.unina.notification_example.port.out.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserRepository userRepository;

    public void createListing(String title) {
        notificationService.sendNotification(userRepository.findAll(),
                "You might like this new listing: " + title);
    }
}
