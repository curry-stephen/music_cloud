package com.yy;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class MyTools {
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
         /*
            全局配置
        */
        String projectPath = System.getProperty("user.dir");
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java") // 生成路径
                .setAuthor("young")                     // 设置作者
                .setOpen(false)                         // 文件生成完成后是否用打开相应的生成路径
                .setFileOverride(true)                  // 是否覆盖已有文件
                .setIdType(IdType.ID_WORKER)                 // 主键策略
               // .setEnableCache(true)                   // 是否开启二级缓存，默认false
                //.setKotlin(false)                       // 开启 Kotlin 模式，默认false
                .setSwagger2(true)  
                // 开启 swagger2 模式，默认false
//                .setActiveRecord(false)                 // 开启 ActiveRecord 模式
//                .setActiveRecord(true)                // AR模式，就是bean有增删改查方法，继承自Model类
                .setDateType(DateType.ONLY_DATE)        // 时间类型对应策略
//                .setDateType()
              // .setEntityName("%sBean")              // 实体命名方式
                .setMapperName("%sMapper")              // dao 命名方式
                .setXmlName("%sMapper")              // Mapper dao 命名方式
                .setServiceName("%sService")           // 设置生成的service接口的名字的首字母是否为I
                .setServiceImplName("%sServiceImp")                   //service impl 命名方式
                .setControllerName("%sController")
                .setBaseResultMap(true);
    // 是否要有映射ResultMap
                //.setBaseColumnList(true);               // 是否要有基础的列

        /*

        数据源配置

        */
        MySqlQuery mySqlQuery = new MySqlQuery() {
            @Override
            public String[] fieldCustom() {
                return new String[]{"Default"};
            }
        };

//        String[] strings = mySqlQuery.fieldCustom();

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/tp_music?serverTimezone=UTC&useSSL=true&useUnicode=true&characterEncoding=UTF-8")
                .setDbType(DbType.MYSQL)     //设置数据库类型[必须属性]
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setDbQuery(mySqlQuery)  
                .setUsername("root")
//                .setTypeConvert((globalConfig, fieldType) -> null) // 自定义映射属性
                .setPassword("123456");


        /*

        策略配置 数据表配置

        */
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true)           //全局大写命名
                //.setSkipView(true)              // 是否跳过视图
                .setLogicDeleteFieldName("deleted") // 添加逻辑删除列
//                .setVersionFieldName("version1")    // 添加版本号充当乐观锁
                .setEntitySerialVersionUID(false)   //  实体是否生成 serialVersionUID，默认为true
              //  .setControllerMappingHyphenStyle(true) //驼峰转连字符，比如：/userEntity -> /user-entity
                .setEntityBuilderModel(true)               // 点进去有介绍
//                .setEntityColumnConstant(true)          // 点进去有介绍
////                .setNameConvert(new INameConvert() {
//
//                    @Override
//                    public String entityNameConvert(TableInfo tableInfo) {
//                        System.out.println(tableInfo.getName());
//                        return tableInfo.getName();
//                    }
//
//                    @Override
//                    public String propertyNameConvert(TableField field) {
//                        System.out.println(field.getName());
//                        return field.getName();
//                    }
//                }) // 名称转换接口
               .setNaming(NamingStrategy.underline_to_camel)
               .setColumnNaming(NamingStrategy.underline_to_camel)  // 数据库表中的字段映射到实例命名，下划线到驼峰
//                .setTablePrefix("kk")                 // 设置要生成代码的数据表前缀
//                .setFieldPrefix("kk")                 // 设置要生成代码的数据表中字段前缀
                .setInclude("admin","collect","comment","consumer","list_song","rank_list","singer","song","song_list") //设置要映射的表名                    // 设置要包含的表
//                .setTableFillList(Arrays.asList(new TableFill("id", FieldFill.INSERT))) //设置自动属性填充
              //  .setColumnNaming()
//                .setExclude()                         // 与包含二选一，排除那些表，两个都允许正则表达式
//                .setSuperEntityClass() //设置实体类要继承的超类
//                .setSuperEntityColumns()      // 自定义基础的Entity类，公共字段
//                .setSuperMapperClass()        //  自定义继承的Mapper类全称，带包名
                .setEntityLombokModel(true) // 设置生成的实体类是Lombok模式
                .setRestControllerStyle(true);  //restful风格
             

        /*

        包配置

        */
        PackageConfig pc = new PackageConfig();

//        pathInfo = new HashMap<>(6);
//        setPathInfo(pathInfo, template.getEntity(getGlobalConfig().isKotlin()), outputDir, ConstVal.ENTITY_PATH, ConstVal.ENTITY);
//        setPathInfo(pathInfo, template.getMapper(), outputDir, ConstVal.MAPPER_PATH, ConstVal.MAPPER);
//        setPathInfo(pathInfo, template.getXml(), outputDir, ConstVal.XML_PATH, ConstVal.XML);
//        setPathInfo(pathInfo, template.getService(), outputDir, ConstVal.SERVICE_PATH, ConstVal.SERVICE);
//        setPathInfo(pathInfo, template.getServiceImpl(), outputDir, ConstVal.SERVICE_IMPL_PATH, ConstVal.SERVICE_IMPL);
//        setPathInfo(pathInfo, template.getController(), outputDir, ConstVal.CONTROLLER_PATH, ConstVal.CONTROLLER);

        pc.setParent("com.yy")    // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                .setMapper("mapper")      // 设置mapper输出的位置
                .setXml("mapper.xml")     // 设置mapper对应的xml输出的位置
//                .setModuleName("bc")      // 父设置模块名
//                .setPathInfo()           // 路径配置信息,就是配置各个文件模板的路径信息
                .setService("service")    // 设置service输出的位置
                .setController("controller") // 设置controller输出的位置
                .setServiceImpl("service.impl") // 设置serviceImpl输出的位置
                .setEntity("pojo");        // 设置beans输出的位置

      /*
          自定义配置，少了这一步会出现空指针异常，在下面这个方法的返回时，出现空指针
           com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine.getObjectMap
      */
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("name", "young");
                map.put("age", 22);
                map.put("sex", "男");
                setMap(map);
            }
        };

//        cfg.setFileOutConfigList(Collections.singletonList(new FileOutConfig("entity.java.btl") {
//
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return System.getProperty("user.home") + File.separator + "desktop" + File.separator + "123.txt";
//            }
//        }));
//        cfg.setFileCreate()       自定义判断是否创建文件


         /*

            代码生成器,将前面的初始化工作进行处理

         */
//        全局配置
        mpg.setGlobalConfig(gc);
//        数据源配置
        mpg.setDataSource(dsc);
//        策略配置
        mpg.setStrategy(strategy);
//        包配置
        mpg.setPackageInfo(pc);
//        自定义配置
        mpg.setCfg(cfg);
//        设置使用Velocity模板引擎
        VelocityTemplateEngine vt = new VelocityTemplateEngine();
        mpg.setTemplateEngine(vt);
//        执行
        mpg.execute();
    }

    
}
