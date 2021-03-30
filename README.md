# StarterOverride
### Normal project with customizations towards Spring boot starter autoconfigurations

---

Currently customized the following:
  - Removed the diskspace health component from `/actuator/health` endpoint
  - Make Datasource with custom settings `(Creds SA/SA with URL jdbc:h2:mem:testDB)` by default.
 ---
Planning to do the following based on time availability:
- [x] Make Datasource with specific settings without configuring any `spring.datasource.*` properties in application.yaml/properties.
>   _Spring Application starts H2 DB with JDBC URL `jdbc:h2:mem:testDB` and username/password  both as `SA`._
- [ ] Extending existing health check component with additional details
- [ ] Adding new health components to HC endpoint
