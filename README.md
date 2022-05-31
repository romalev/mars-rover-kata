## Mars Rover Kata

# Intro

Here you'll find a java mvn based implementation of `Mars Rover Kata` according to given requirements.

# How to

There's a `app.rover.kata.RoverKataTestingSuite` test suite - fire it up and see how it works.

`app.rover.kata.CommandExecutor` is a central interface around the app.

# Additional

Given app might be externalized into a small library which later can be hooked into a TCP service through which commands
are flowing in (or through some custom network protocol).

Given app can be easily extended to save current rover's location in non-volatile memory in case power outage takes
place.

Given app **is not intelligent enough** to handle any `obsticles` a rover might bump into on its way. It might be worth
thinking of how to tackle obsticles.


