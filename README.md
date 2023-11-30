# springboot脚手架

    快速搭建基本环境工程

## 简洁类似DDD分层结构脚手架

    目前大部分的开发按照MVC的模式进行开发， 经过一段时间的迭代演变， 发现工程结构， 分包变的混乱无比， 完全按照的DDD的设计理念对于一般的CRUD业务会发现非常的繁琐，会发现各种对象的转换， 导致开发效率变的底下，在此背景下，基于当前公司要求的快速迭代，又为了保证结构清晰，仿DDD设计进行了脚手架搭建，不会完全按照DDD的理念

## 模块说明

| 模块名称                        | 模块说明                           | 依赖模块 |
| ------------------------------- | ---------------------------------- | -------- |
| simple-ddd-frame-application    | 应用层，编排业务，不实现具体的逻辑 | domain   |
| simple-ddd-frame-base           | 通用基础模块                       |          |
| simple-ddd-frame-domain         | 领域层                             |          |
| simple-ddd-frame-infrastructure | 基础设施层                         |          |
| simple-ddd-frame-interface      | 用户接口层，controller之类         |          |
| simple-ddd-frame-starter        | 启动层                             |          |

