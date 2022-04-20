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
