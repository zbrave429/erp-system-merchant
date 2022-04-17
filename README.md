# 商户数据中心服务（MDC）

基于dubbo3.x开发的零售微服务系统，包含微服务编程最佳实践，持续更新🚀️

### 1. 功能清单


| 模块         | 子模块                                         | 接口                              | 状态 | 单元测试覆盖 |
| :------------- | :----------------------------------------------- | :---------------------------------- | :----: | :------------: |
| __商户管理__ | 商户基础信息管理<br />（MerchantService）      | 新增(createMerchant)              |  ✅  |      ✅      |
|              |                                                | 批量新增(*规划中*)                |  ❌  |              |
|              |                                                | 修改(updateMerchant)              |  ✅  |      ✅      |
|              |                                                | 删除(removeMerchant)              |  ✅  |      ✅      |
|              | 商户基础信息查询<br />（MerchantQueryService） | 单条数据查询(queryById)           |  ✅  |              |
|              |                                                | 批量查询(queryListByIds)          |  ✅  |              |
|              |                                                | 分页查询(queryByPage)             |  ❌  |              |
| __门店管理__ | 门店基础信息管理接口<br />（ShopService）      | 新增(createShop)                  |      |              |
|              |                                                | 修改(updateShop)                  |      |              |
|              |                                                | 删除(removeShop)                  |      |              |
|              |                                                | 批量新增                          |      |              |
|              | 门店基础信息查询接口<br />（ShopQueryService） | 根据门店ID查询单条记录(queryById) |  ✅  |      ✅      |
|              |                                                | 批量多条件查询(queryListByIds)    |  ✅  |      ✅      |
|              |                                                | 分页多条件查询(queryPage)         |  ✅  |      ✅      |
|              |                                                |                                   |      |              |
| __用户管理__ | 用户基础信息管理接口<br />（UserService）      | 新增(createUser)                  |      |              |
|              |                                                | 修改(updateUser)                  |      |              |
|              |                                                | 删除(removeUser)                  |      |              |
|              | 用户基础信息查询接口<br />（UserQueryService） | 根据用户ID查询单条记录            |      |              |
|              |                                                | 批量多条件查询查询                |      |              |
|              |                                                | 分页多条件查询                    |      |              |

---

### 2. 技术栈

* java 8
* dubbo 3.0.6
* springboot 2.3.12.RELEASE
* mysql 8.0.28
* nacos 2.+
* redis 5.0+
* mybatis 3.5.9

---

### 3. 包说明

#### 3.1 api包，接口调用方引入（erp-system-merchant-api）

```java
<dependency>
    <groupId>com.brave</groupId>
    <artifactId>erp-system-merchant-api</artifactId>
</dependency>
```

* dto - 数据模型
* enums - 相关枚举
* request - 请求参数模型
* response - 响应参数模型
* service - 服务接口定义

#### 3.2 服务包（erp-system-merchant-service）
