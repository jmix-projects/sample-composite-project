# Sample Composite Project

This project demonstrates a possible approach to work with add-ons and applications using them in a single IDE project, without the need to publish add-ons to test them in the applcation.

The composite project consists of the following subprojects:

- `users`, `customers`, `projects` - add-ons
- `sales` - target application
- `all` - aggregating composite project

The subprojects can be stored in separate Git repositories.

Dependencies between the subprojects:

![deps](http://www.plantuml.com/plantuml/png/SoWkIImgAStDuOekJin9BOvLqDMrKuWkBKujAev55KikBIx9pyKKBoZAJobDBW4AmvMW6GDJWYRia9gN0hGP0000)


## Usage

- Clone the repository.
- Open `./all` directory in IntelliJ IDEA with Jmix Studio plugin installed.
- Wait until Gradle import is finished.