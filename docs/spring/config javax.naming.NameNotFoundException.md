# javax.naming.NameNotFoundException

msg

```
DEBUG JndiTemplate:150 - Looking up JNDI object with name [java:comp/env/spring.liveBeansView.mbeanDomain]
DEBUG JndiLocatorDelegate:101 - Converted JNDI name [java:comp/env/spring.liveBeansView.mbeanDomain] not found - trying original name [spring.liveBeansView.mbeanDomain]. javax.naming.NameNotFoundException: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].
DEBUG JndiTemplate:150 - Looking up JNDI object with name [spring.liveBeansView.mbeanDomain]
DEBUG JndiPropertySource:87 - JNDI lookup for name [spring.liveBeansView.mbeanDomain] threw NamingException with message: Name [spring.liveBeansView.mbeanDomain] is not bound in this Context. Unable to find [spring.liveBeansView.mbeanDomain].. Returning null.
DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemProperties]
DEBUG PropertySourcesPropertyResolver:81 - Searching for key 'spring.liveBeansView.mbeanDomain' in [systemEnvironment]
DEBUG PropertySourcesPropertyResolver:103 - Could not find key 'spring.liveBeansView.mbeanDomain' in any property source. Returning [null]
DEBUG DispatcherServlet:533 - Published WebApplicationContext of servlet 'spring' as ServletContext attribute with name [org.springframework.web.servlet.FrameworkServlet.CONTEXT.spring]
```

`web.xml`

```xml
	<context-param>
		<param-name>spring.profiles.active</param-name>
		<param-value>dev</param-value>
	</context-param>
	<context-param>
		<param-name>spring.profiles.default</param-name>
		<param-value>dev</param-value>
	</context-param>
	<context-param>
		<param-name>spring.liveBeansView.mbeanDomain</param-name>
		<param-value>dev</param-value>
	</context-param>

```
