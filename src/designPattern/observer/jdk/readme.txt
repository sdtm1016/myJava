关于触发通知的时机:
分为pull和pop模型
推模型:subject主动向observer进行pull详细信息stage,stage通常是observer的全部或部分数据
拉模型:subject在向observer进行notify时,只send少量message,
observer如果需要获取更多数据,需要observer主动到subject中去pop

拉模型是subject不知道observer具体需要那些数据,因此把subject自己传给观察者,由观察者来取值

推模型会使observer对象难以复用
拉模型update方法参数是subject本身,基本上适应各种情况需要


利用java自带的观察者与自己实现对比:
1.不需要定义Observer和Subject几口,jdk已经定义好
2.具体的Subject实现里不需要再维护Observer注册信息,Java中的Observale类里已经实现好了
3.触发通知方式有一点变化,要先盗用setChanged方法,这个是Java为帮助实现更精准的触发控制提供的功能
4.具体observer的实现里,update方法及时能同事支持推模型和拉模型,这个是Java在定义时候,已经考虑进去了