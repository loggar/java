## TypeParameters Wildcards Bounds

```
<T> Unbounded type; same as <T extends Object>
<T,P> Unbounded types; <T extends Object> and <P extends Object>
<T extends P> Upper bounded type; a specific type T that is a subtype of type P
<T extends P & S> Upper bounded type; a specific type T that is a subtype of type P and that implements type S
<T super P > Lower bounded type; a specific type T that is a supertype of type P
<?> Unbounded wildcard; any object type, same as <? extends Object>
<? extends P> Bounded wildcard; some unknown type that is a subtype of type P
<? extends P & S> Bounded wildcard; some unknown type that is a subtype of type P and that implements type S
<? super P> Lower bounded wildcard; some unknown type that is a supertype of type P
```