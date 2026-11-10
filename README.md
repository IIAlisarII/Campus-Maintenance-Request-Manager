# Campus-Maintenance-Request-Manager
Console-based Java app for managing campus maintenance requests, the system allows the user to add requests, search for requests, display pending requests in priority order, and process the next request. (Qatar University, CMPS303)

## Context
Team project for CMPS303 at Qatar University, Fall 2026 (team of four).

## Features
- Add a request (location, description, priority: High / Medium / Low)
- Auto-generated sequential IDs that are never reused
- Search any request (pending or completed) by ID
- View pending requests ordered by priority, then oldest first
- Process the highest-priority, oldest pending request
- Save to a binary file on exit and reload on startup

## How we ae going to make this
- Java
- Object serialization for persistence
- Custom-implemented data structures (no built-in collection classes)

## Status
In progress.
