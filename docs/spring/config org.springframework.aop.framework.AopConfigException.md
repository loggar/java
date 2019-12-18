# 

msg

```
[DEBUG] [localhost-startStop-1] 18/12/2019 11:28:33.807 org.springframework.aop.framework.CglibAopProxy$ProxyCallbackFilter.accept - Unable to apply any optimisations to advised method: protected native java.lang.Object java.lang.Object.clone() throws java.lang.CloneNotSupportedException
[DEBUG] [localhost-startStop-1] 18/12/2019 11:28:33.809 org.springframework.aop.framework.CglibAopProxy$ProxyCallbackFilter.accept - Method is declared on Advised interface: public abstract boolean org.springframework.aop.framework.Advised.replaceAdvisor(org.springframework.aop.Advisor,org.springframework.aop.Advisor) throws org.springframework.aop.framework.AopConfigException
[DEBUG] [localhost-startStop-1] 18/12/2019 11:28:33.809 org.springframework.aop.framework.CglibAopProxy$ProxyCallbackFilter.accept - Method is declared on Advised interface: public abstract void org.springframework.aop.framework.Advised.removeAdvisor(int) throws org.springframework.aop.framework.AopConfigException
```

Remove Proxy

```xml
	<aop:config proxy-target-class="true">
		<aop:pointcut id="serviceOperationPointcut" expression="execution(* com.koi.service..*Service.*(..))" />
		<aop:advisor id="transactionAdvisor" pointcut-ref="serviceOperationPointcut" advice-ref="transactionAdvice" order="2" />
	</aop:config>
```

```xml
	<aop:config>
		<aop:pointcut id="serviceOperationPointcut" expression="execution(* com.koi.service..*Service.*(..))" />
		<aop:advisor id="transactionAdvisor" pointcut-ref="serviceOperationPointcut" advice-ref="transactionAdvice" order="2" />
	</aop:config>
```
