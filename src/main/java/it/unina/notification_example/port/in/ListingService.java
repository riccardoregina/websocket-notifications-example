package it.unina.notification_example.port.in;

import it.unina.notification_example.adapter.in.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {

    @Autowired
    private NotificationService notificationService;

    public void createListing(String title) {
        notificationService.sendNotification("New listing posted, title " + title);
    }
}
