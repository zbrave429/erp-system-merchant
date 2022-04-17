# 商户数据中心服务（MDC）

基于dubbo3.x开发的零售微服务系统，包含微服务编程最佳实践，持续更新🚀️ 

### 1. 功能清单


| 模块         | 子模块                                         | 接口                     | 状态 |
| :------------- | :----------------------------------------------- | :------------------------- | :----: |
| __商户管理__ | 商户基础信息管理<br />（MerchantService）      | 新增(createMerchant)     |  ✅  |
|              |                                                | *~~批量新增~~*           |  ❌  |
|              |                                                | 修改(updateMerchant)     |  ✅  |
|              |                                                | 删除(removeMerchant)     |  ✅  |
|              | 商户基础信息查询<br />（MerchantQueryService） | 单条数据查询(queryById)  |  ✅  |
|              |                                                | 批量查询(queryListByIds) |  ✅  |
|              |                                                | 分页查询(queryByPage)    |  ❌  |
| __门店管理__ | 门店基础信息管理接口<br />（ShopService）      |                          |      |
|              | 门店基础信息查询接口<br />（ShopQueryService） |                          |      |
| __用户管理__ | 用户基础信息管理接口<br />（UserService）      |                          |      |
|              | 用户基础信息查询接口<br />（UserQueryService） |                          |      |

---



### 2. 技术栈

* java 8
* dubbo 3.0.6
* 2.3.12.RELEASE
* mysql 8.0.28
* nacos 2.+
* redis 5.0+

---
