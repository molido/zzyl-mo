## 中州养老项目

## 前端运行

```bash
# 克隆项目
git clone https://github.com/molido/zzyl-mo.git

# 进入项目目录
cd zzyl-mo

# 安装依赖
yarn --registry=https://registry.npmmirror.com

# 启动服务
yarn dev

# 构建测试环境 yarn build:stage
# 构建生产环境 yarn build:prod
# 前端访问地址 http://localhost:80
```

## 后端运行
```bash
cd .zzylBackend/zzyl-admin && mvn -q -DskipTests spring-boot:run | cat
```
