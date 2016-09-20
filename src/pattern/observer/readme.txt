观察者模式实现observer和subject之间的抽象耦合
实现了动态联动,支持广播通信
本质:
1.当一个抽象模型有两个方面A和B,其中A的操作依赖于B的状态变化
2.如果在更改A对象时,同事需要连带改变B,C,D..且不知道一共有具体多少对象被连带改变
3.当A必须通知其他对象B,C,D..,但又要确保A与这些对象送耦合

observer(观察者模式) parttern code mode:
1.observer(观察者)定义subject改变时,自我更新方法update
2.subject(目标对象)私有observer的list,并定义对observer的注册,删除,通知方法
3.observer impl实现接口的subject更新,使自身和subject一致
4.subject impl私有observer的状态state,负责讲状态存入observer中
