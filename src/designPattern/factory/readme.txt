编码时候不能预见需要new那种类实例
考虑扩展性,不应依赖于产品实例new,组合和表达细节
设计要求:
1.尽量松耦合,一个对象不依赖对象的变化
2.具体产品与客户端剥离,责任分割
抽象工厂类特征:
抽象工厂类A对接口类P分类,工厂类B,C继承A分别进行分支实现;

案例解释:
Person有四中实现:HNBoy,HNGirl,MCBoy,MCGirl
通过工厂方法实例化一个实现类需要两个维度的定义,
在这里对工厂方法进行分类(接口)分支(实现类)实现
1.抽象工厂类PersonFactory抽象get方法实现到对应的Boy/Girl接口
1.工厂类HNFactory/MCFactory继承PersonFactory,进一步实例化
分别对Boy/Girl接口进一步实例化
例如:在Client中
Person p1 = new HNFactory().getGirl();
Person p2 = new HNFactory().getBoy();
Person p3 = new MCFactory().getGirl();
Person p4 = new MCFactory().getBoy();