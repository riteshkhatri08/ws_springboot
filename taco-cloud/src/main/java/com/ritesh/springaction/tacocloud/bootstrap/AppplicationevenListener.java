package com.ritesh.springaction.tacocloud.bootstrap;


//  ! This doesn't work it is called after it dispatcher has been initialized

// @Slf4j
// @Configuration
public class AppplicationevenListener {
    // @Bean
    // public ApplicationListener<ApplicationStartedEvent> delayApplicationStartup() {
    //     return event -> {
    //         try {

    //             log.error("**********************************************************************************");
    //             log.debug(
    //                     "Inside AppplicationevenListener : Application has been initilialized but MAY not ready to receive traffic");
    //             log.error("SLEEPING for 15 seconds , meanwhile you can check if application is accepting traffic");
    //               CountDownLatch latch = new CountDownLatch(1);
    //             Thread.sleep(15000); // Simulate initialization delay
    //             latch.countDown();
    //             log.error("AppplicationevenListener JUST WOKE UP FROM 15 second sleep..");
    //             log.error("**********************************************************************************");
    //         } catch (InterruptedException e) {
    //             Thread.currentThread().interrupt();
    //         }
    //     };
    // }
}
