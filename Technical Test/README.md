# Discussion

## JMeter & Gatling for Performance Testing

Performance testing is a completely different world to functional testing, but plays a quite important role in the development of efficient and robust apps, and Jmeter or Gatling are amazing tools that aid in this matter. These tools are made to simulate different user loads in web apps or web services, and generate great amounts of HTTP requests. JMeter, on one hand, is an interesting option for _stress testing_ and identifying possible performance bottlenecks. Gatling, on the other hand, is quite good at generating user behavior to generate _load_, so it is a great option to use in _load testing_.

## Selenium for Functional Testing

Functional testing is what most people would think when they hear the word _Testing_, and it is for good reason. Functional testing verifies that the system meets the functional requirements, in other words, if it works as it should. There are a huge number of frameworks and tools that aid in this matter, but one of the most known is _Selenium_. This tool helps during the automation of functional test cases where the interaction with the _user interface_ is needed; it verifies that the expected conditions are met and that the requirements are met.

## Approaches to Functional and Performance Testing

As previously stated, these two are completely different worlds that aim at different parts of the _application under test_. Performance adresses non-functional elements of the application, such as response time, latency, system capacity, or bottlenecks, and Functional focuses more on the correct functioning of components, features, interactions etc.

Nevertheless, these two are not completely unrelated as it might seem, they have the same goal of assesing the quality of the application, and not only that but both have to work with real-life-like scenarios that mimic the user's behavior in order to see if the application meets the expectations of the client. That is why the use of _scenarios_ that mimic real life use is one of their common grounds.

All in all, both approaches are quite important in the testing process of an application

## What could happen if the parameters or arguments change after the script creation?

This is a valid question and a very important one to ask, since depending on the change it could have a bigger impact. These can affect the stability and trust on the test framework. Here are some examples of some changes that could impact the reliability:

- If the change is in the _User Interface_, for example changing the element identifiers, it would depend on how robust was the framework done, as there are better ways to locate elements; however, it would definetely have an impact when finding the elements during the execution and will cause errors when not finding what is expected. In this case the solution would be to be notified about the change and update the test automation framework to reflect the changes.

- If the change is in the _Application Flow_, like adding steps or modifing existing ones in the sequence, the automation scripts could lose their sync with the app and lead to false positives or negatives that do not reflect the current state of the app. This is a more complex type of issue, but using design models that help to better maintain or update the tests (like _POM_ or _Screenplay_) will make the debugging a lot easier

These are two examples of changes that could affect how reliable or how stable the test framework would be after changing something in the application, yet there are different approaches to minimize the impact of each of them. Making the scripts easy to maintain or modify according to the needs is almost always the answer to these situations, so the use of _design patterns_ is always encouraged.
