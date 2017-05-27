# jetty-lab

Simple gradle project to set up a web app that gradle can run in Jetty.  To run:

gradle jettyRun

There is a single servlet at:

http://localhost:8080/test

A very simple service (which returns current timestamp) is registered using a servlet context listener.

Much more can be added but this has everything for 1) a basic servlet app with 2) a service in the context that 3) is built using gradle and 4) can be run easily using gradle.
