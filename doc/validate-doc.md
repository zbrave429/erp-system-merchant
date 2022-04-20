## 接口参数校验注解使用指南


| 注解        | 支持的参数类型 | 描述                       |
| ------------- | ---------------- | ---------------------------- |
| Valid       | object         | 检查对象内的字段值         |
| Null        | object         | 被注释的元素必须为 null    |
| NotNull     | object         | 被注释的元素必须不为 null  |
| AssertTrue  | Boolean        | 被注释的元素必须为 true    |
| AssertFalse | Boolean        | 被注释的元素必须为 false   |
| NotEmpty    | string         | 字符串不能为null或空字符串 |
|             | 集合           | 集合size > 0               |
| NotBlank    | string         | 字符串trim()后length > 0   |
|             |                |                            |
|             |                |                            |

### jar包引入

注意：

Service端必须要引入javax.el包，否则会出现以下报错

javax.validation.ValidationException: HV000183: Unable to initialize 'javax.el.ExpressionFactory'. Check that you have the EL dependencies on the classpath, or use ParameterMessageInterpolator instead

```java
<!-- api -->
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version>
</dependency>

<!-- service -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.3.Final</version>
</dependency>
<dependency>
    <groupId>org.glassfish</groupId>
    <artifactId>javax.el</artifactId>
    <version>3.0.1-b12</version>
</dependency>
```
