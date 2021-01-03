# 设计模式

## 设计模式-创建型模式
***
### 工厂方法模式 Factory Method
+ 简单工厂 Simple Factory：
  + [演示Demo1-算数器](../src/main/java/factory/simplefactory/operation/SimpleFactoryTestDemo.java)
  + [演示Demo2-商店结账器](../src/main/java/factory/simplefactory/shop/CashFactory.java)
+ 工厂模式 ：
  + [演示Demo1-算数器](../src/main/java/factory/operation/FactoryTestDemo.java)
  + 定义一个用于创建对象的接口，让子类决定实例化哪个类；
  + 简单工厂与工厂模式的区别：
    + 简单工厂：工厂类包含了必要的逻辑判断，根据选择条件动态实例化对象；但扩展时需修改判断逻辑，破坏了“开闭原则”；
    + 工厂方法：定义一个创建对象的接口，让子类决定实例化哪一对象；但扩展时需要修改客户端的代码；
    + 工厂方法模式是简单工厂模式的进一步抽象和推广；

### 抽象方法模式 Abstract Factory
+ [演示Demo](../src/main/java/factory/abstractfactory/AbstractFactoryExampleClass.java)
+ 提供一个创建一些列相关或相互依赖对象的接口，而无需指定它们具体的类；
+ 优点：一便于交换变更产品系列，新增修改只需处理具体的工厂；二是具体创建实例过程与客户端分离，客户端通过抽象接口操纵实例，产品的具体类名也被具体工厂的实现分离；
+ 缺点：若需要增加功能，需要改动的地方多；调用实例时均需工厂创建（可使用简单工厂来改进，但新增时仍然需要改动——>反射+抽象工厂实现）；

### 建造者模式 Builder
+ [演示Demo](../src/main/java/builder/BuilderExampleClass.java)
+ 又称：生成器模式
+ 将一个复杂对象的构建与表示分离，使同样的构建过程可以创建不同的表示；
+ 关键角色：
  + Builder：建造接口；
  + ConcreteBuilder：具体的建造者，实现 Builder 接口；
  + Product：需建造的产品（对象）；
  + Director：指挥者，控制建造过程；
+ 用途：主要用于创建复杂的对象，而对象内部构件间构建的顺序是稳定的，但对象外部的构建是面临复杂的变化；

### 单例模式 Singleton
+ [演示Demo](../src/main/java/singleton/SingletonExampleClass.java)
+ 保证一个类仅有一个实例，并提供一个访问它全局访问点；
+ 好处：可严格地控制客户访问，方便管理；节省内存、节省计算；
+ 两种模式：
  + 懒汉式单例类：第一次被引用时才实例化；需注意多线程处理的问题；
  + 饿汉式单例类：在自己被加载时就实例化；类加载就实例化对象，需要提前占用系统资源；
+ 单例模式的多种实现：
  + [饿汉式（静态变量，可用）](../src/main/java/singleton/SingletonExampleClass.java)
  + [饿汉式（静态代码块，可用）](../src/main/java/singleton/StaticBlockSingleton.java)
  + [懒汉式（线程不安全，不可用）](../src/main/java/singleton/HungrySingleton.java)
  + [懒汉式（线程安全，同步方法，不推介使用）](../src/main/java/singleton/SyncSingleton.java)
  + [懒汉式（线程不安全，同步代码块，不可用）](../src/main/java/singleton/SyncBlockSingleton.java)
  + [双重检查（推介使用）](../src/main/java/singleton/DoubleCheckSingleton.java)
  + [静态内部类](../src/main/java/singleton/InnerClassSingleton.java)
  + [枚举](../src/main/java/singleton/EnumSingleton.java)
+ 单例模式的破坏与解决办法：
  + [Demo](../src/main/java/singleton/SingletonTestDemo.java)
```java
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Singleton implements Serializable {

    private static Singleton instance = new Singleton();

    // 通过反射方式
    // 反射是通过调用构造方法生成新对象；只需在构造方法中进行对对象的判断即可；
    private Singleton() {
      if (instance != null) {
        throw new RuntimeException("实例已存在");
      }
    }

    // 反序列化破坏单例
    // 解决一：不实现序列化接口 Serializable；
    // 解决二：实现序列化接口，重写反序列化方法 readResolve()；
    public Object readResolve() throws ObjectStreamException {
        return instance;
    }
    
    public static Singleton getInstance() {
        return instance;
    }
  
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1);
        
        Class clazz = Class.forName(Singleton.class.getName());
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton singleton2 = (Singleton) constructor.newInstance();
        System.out.println(singleton2);
    }
}
```

### 原型模式 Prototype
+ [演示Demo](../src/main/java/prototype/PrototypeExampleClass.java)
+ 用原型实例指定创建对象的种类，并且通过**拷贝**这些原型创建新的对象；(从一个对象创建另一个可定制的对象)
+ 优点：初始化的信息不发生变化的情况下，克隆是最好的办法；因为既隐藏了对象创建的细节，又对性能是大大的提高；
+ 浅拷贝和深拷贝
  + 浅拷贝：值类型复制，引用对象只拷贝引用，不拷贝对象；（复制后的对象共用同一个引用对象）
  + 深拷贝：全部都拷贝；

## 设计模式-结构性模式
***
### 外观模式 Facade
+ [演示Demo](../src/main/java/facade/FacadeExampleClass.java)
+ 为子系统中的一组接口提供一个一致的界面；此模式定义了一个高层接口，使得这一子系统更加容易使用；
+ 适用场景：
  + 设计初期，合理地分层；（如 MVC 三层架构，数据访问层-业务逻辑层-表示层）
  + 开发阶段，子系统因不断重构演化而变得越来越复杂，可增加外观 Facade 提供一个简单接口供外部调用，从而减少依赖；
  + 维护遗留的大型系统，该系统难以维护和拓展但包含十分重要的功能，而新的需求又必须依赖它；可增加 Facade 外观类，来提供设计粗糙或高度复杂的遗留代码的比较清晰简单的接口，让新系统与 Facade 对象交互；

### 装饰者模式 Decorator
+ [演示Demo1](../src/main/java/decorator/DecoratorTestDemo.java)
+ [演示Demo2-人类穿衣](../src/main/java/decorator/person/DecoratorPersonTestDemo.java)
+ 动态地为对象添加一些额外的职责；就增加功能来说，装饰模式比生成子类更为灵活；
+ 设计目的：当系统需要新功能时，向旧的类添加代码；这种新加的代码通常装饰了原来类的核心职责或主要行为；简化原类；
+ 好处：有效地把类的核心职责和装饰功能区分开，而且可去除相应类中重复的装饰逻辑；

### 适配器模式 Adapter
+ [演示Demo](../src/main/java/adapter/AdaptExampleClass.java)
+ 将一个接口转换成客户希望的另一个接口；Adapt 模式使原来由于接口不兼容而不能一起工作的那些类可以一起工作；
+ 适用：系统的数据和行为正确，但接口不符；应用于希望复用现存的一些类，解决接口与复用环境要求不一致的情况；
+ 目的：使控制范围之外的一个原有对象与某个接口匹配；
+ 类型：
  + 类适配器模式：通过多重继承对一个接口与另一个接口进行匹配；（不适用于不能多重继承的语言）
  + 对象适配器模式

### 享元模式 Flyweight
+ [演示Demo](../src/main/java/flyweight/FlyweightExampleClass.java)
+ [演示Demo-网站分类共享](../src/main/java/flyweight/website/Main.java)
+ 运用共享技术有效地支持大量细粒度的对象；
+ 内部状态与外部状态：
    + 内部状态：不会随环境改变而改变的共享部分；
    + 外部状态：随环境改变而改变、不共享的状态；
+ 好处：避免大量细粒度对象，提高系统运行的性能；
+ 适用场景：
    + 若一个应用程序使用了大量的对象，而大量的对象会造成很大的存储开销时使用；
    + 对象大多数的情况下可以外部状态，可删除对象的外部状态用相对少的共享对象取代；    

### 组合模式 Composite
+ [演示Demo](../src/main/java/composite/CompositeExampleClass.java)
+ [演示Demo-公司部门架构](../src/main/java/composite/company/CompanyCompositeExampleClass.java)
+ 将对象组合成树形结构以表示“部分-整体”的层次结构；使用户对单个对象和组合对象的使用具有一致性；
+ 透明模式：抽象接口**声明**叶子节点不能实现的方法；使叶子节点和枝节点对于外界是没有区别的；但叶子节点实现无意义；
+ 安全模式：抽象接口**不声明**叶子节点不能实现的方法；客户端调用时需作判断；
+ 适用场景：需求中体现**部分与整体**层次的结构时；
+ 好处：可以一致地使用组合结构和单个对象；

### 桥接模式 Bridge
+ [演示Demo](../src/main/java/bridge/BridgeExampleClass.java)
+ [演示Demo-手机硬件与软件](../src/main/java/bridge/headphone/Client.java)  
+ 将抽象部分与它的实现部分分离，使它们都可以独立地变化；
+ 组合/聚合复用原则的最佳实现；

### 代理模式 Proxy
+ [演示Demo](../src/main/java/proxy/ProxyExampleClass.java)
+ [演示Demo-送礼物](../src/main/java/proxy/Proxy.java)
+ 为其他对象提供一种代理以控制对这个对象的访问；【在访问对象时引入一定程序的间接性（可附加多种用途）】
+ 适用场景：
    + 远程代理：为一个对象在不同的地址空间提供局部代表；可以隐藏一个对象存在于不同地址空间的事实；
    + 虚拟代理：解决需要创建开销很大的对象；为达性能最优化，通过代理来存放需要长时间实例化的真实对象；
    + 安全代理：控制真实对象访问时的权限；
    + 智能指引：调用真实的对象时，代理处理另外一些事；

## 设计模式-行为型模式
***
### 策略模式 Strategy
+ [演示Demo](../src/main/java/strategy/Context.java)
+ [策略模式与简单工厂模式结合Demo](../src/main/java/factory/simplefactory/shop/CashContext.java) 
+ 定义了算法家族，分别封装起来，让他们之间可以互相替换；让算法的变化不会影响到使用算法的客户；
+ 所有算法完成都是相同的工作，但实现不同；
+ 策略模式封装了变化；  
+ 优点：每种算法都有自己实现的类，简化了单元测试；每个算法修改不会影响到其他算法；

### 观察者模式 Observer
+ [演示Demo](../src/main/java/observer/ObserverExampleClass.java)
+ 又称：发布-订阅模式 Publish-Subscribe  
+ 定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象；这主题对象在状态发生变化时，会通知所有观察者，让其对象自动更新自己；
+ 目的：一个系统分割成一系列互相协作的类需要维护相关对象间的一致性；为维护一致性不应该使各类紧密耦合，若耦合则维护、扩展和重用都不便；
+ 适用：当一个对象的改变需要同时改变其他对象，而且不知道具体有多少对象需改变；
+ 不足：通知者需要依赖观察者的接口；

### 责任链模式 Chain of Responsibility
+ [演示Demo](../src/main/java/chainofresponsibility/ChainOfResponsibilityExampleClass.java)
+ [演示Demo-公司请求申请](../src/main/java/chainofresponsibility/company/Main.java)
+ 使多个对象有机会处理请求，避免请求的发送者与接受者之间的耦合关系；将对象连成一条链，并沿着这条链传递请求，直到有一个对象处理为止；
+ 好处：
    + 请求者不需指定哪个对象来处理，只需将请求提交；
    + 职责链简化对象相互的连接，仅需保持一个指向其后继者的引用，而不需保持它所有的候选接收者的引用，大大降低了耦合度；
+ 注意：一个请求可能到达链的末端都得不到处理，或者因为没有正确配置而得不到处理；

### 备忘录模式 Memento
+ [演示Demo](../src/main/java/memento/MementoExampleClass.java)
+ [演示Demo-游戏进度恢复](../src/main/java/memento/GameMementoExampleClass.java)
+ 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态；这样以后就可将该对象恢复到原先保存的状态；
+ 模式成员
  + 发起者 Originator：负责创建备忘录，并记录当前时刻的内部状态，可使用备忘录恢复到已记录的内部状态；
  + 备忘录 Memento：活动的主体；
  + 管理者 Caretaker：存储可恢复活动的状态；
+ 适用场合：
  + 适用于功能比较复杂，但需要维护或记录属性历史的类；或者需要保存的属性只是众多属性中的一小部分时，发起者可以根据保存额备忘录信息还原；
  + 若系统中使用命令模式时，需要实现命令的撤销功能，那么命令模式可以使用备忘录模式来存储可撤销操作的状态；
  + 保存封装的边界：一对象的内部信息必须保存在对象以外的地方，但需要对象自己兑取；备忘录模式可以把复杂的对象内部信息对其他对象屏蔽起来；
+ 缺点：备忘录对象需要完整保存，若数据量大，会非常消耗内存；

### 模版方法模式 TemplateMethod
+ [演示Demo](../src/main/java/templatemethod/TemplateMethodExampleClass.java) 
+ 大致的过程或步骤是相同的，但个别过程或步骤是不同的；
+ 定义：定义了一个操作中的算法的骨架，将一些步骤延迟到子类中；模版方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定的步骤；
+ 优点：良好的代码复用平台；

### 迭代器模式 Iterator
+ [演示Demo](../src/main/java/iterator/IteratorExampleClass.java)
+ 提供一种方法顺序访问一个聚合对象中各个元素，而又不暴露该对象的内部表现；
+ 总结：分离了集合对象的遍历行为，抽象出一个迭代器类来负责；可不暴露集合内部结构，又可让外部代码透明地访问集合内部的数据；

### 中介者模式 Mediator
+ [演示Demo](../src/main/java/mediator/MediatorExampleClass.java)
+ 又称：调停者模式
+ 用一个中介对象来封装一系列的对象交互；中介者使各对象不需要显式地互相引用，从而松耦合，而且可独立地改变它们之间的关系；
+ 优点：减少各个需要互相通信对象的耦合度；
+ 缺点：容易误用；

### 命令模式 Command
+ [演示Demo](../src/main/java/command/CommandExampleClass.java)
+ 将请求封装成一个对象，从而可以用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤销的操作；
+ 优点：
  + 较容易设计一个命令队列；
  + 在需要的情况下，可容易地将命令记入日志；
  + 接收请求的一方可以决定是否否决请求；
  + 容易实现对请求的**撤销、恢复和重做**；
  + 容易新增新的命令，并不影响旧的命令，符合开闭原则；
  + 命令模式将命令的请求和命令的执行分隔开；

### 访问者模式 Visitor
+ [演示Demo](../src/main/java/visitor/VisitorExampleClass.java)
+ [演示Demo-男女行为](../src/main/java/visitor/person/Main.java)
+ 表示一个作用于某对象结构中的各元素的操作；可在不改变各元素的类的前提下定义作用于这元素的新操作；
+ 可实施的前提：
    + 大白话：对象类型是确定的，而对象的状态是不确认的；
    + 适用于数据结构相对稳定的系统；
+ 目的：将处理从数据结构中分离出来，解耦合；
+ 优点：容易添加新的操作；
+ 缺点：很困难添加新的数据结构；

### 解释器模式 Interpreter
+ [演示Demo](../src/main/java/interpreter/InterpreterExampleClass.java)
+ [演示Demo-音乐解析器](../src/main/java/interpreter/music/AbstractExpression.java)
+ 给定一个语言，定义它的文法的一种表示，并定一个解释器，来解释语言中的句子；
+ 若一种特定类型的问题发生的频率高，那么可以将该问题的各个势力表述为一个简单语言的句子，构成一个解释器；通过解释器解释句子来解决该问题；
+ 应用场景：正则表达式、网页浏览器（解释HTML）等；
+ 适用场景：当一个语言需要解释执行，并且该语言中的句子可以表示为一个抽象的语法树时；
+ 优点：可容易改变和扩展文法；

### 状态模式 State
+ [演示Demo](../src/main/java/state/StateExampleClass.java)
+ [演示Demo-工作状态](../src/main/java/state/WorkerStateExampleClass.java)
+ 当一个对象的内在状态改变时允许改变其行为，这个对象看起来像是改变了其类；
+ 解决：当控制一个对象状态转换的条件表达式过于复杂；把状态的判断逻辑转移到表示不同状态的一系列类中，把复杂的判断逻辑简化；
+ 适用：当一个对象的行为取决于它的状态，并且它必须在运行时刻根据状态改变它的行为时；
+ 好处：将与特定状态相关的行为局部化，并且跟不同状态的行为分割开；消除庞大的条件分支语句；