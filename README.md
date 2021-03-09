# StarterOverride
### Normal project with customizations towards Spring boot starter autoconfigurations

Currently customized the following:
  - Removed the diskspace health component from `/actuator/health` endpoint
 
Planning to do the following based on time availability:
  - Make Datasource with specific settings without configuring any `spring.datasource.*` properties in application.yaml/properties.
  - Extending existing health check component with additional details
  - Adding new health components to HC endpoint
