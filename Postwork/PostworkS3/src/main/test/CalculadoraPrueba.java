class CalculadoraPrueba {

    //Stream o Collection, se usa Stream y regresa el método DynamicTest
    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStreamInJava8() {
        //Inicializar objeto calculadora para comprobación
        Calculadora calculadora = new Calculadora();

        //Definir conjunto de datos, 1. valores de entrada  (0 - 9999)
        List<Integer> entradas = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        //Definir conjunto de datos, 2. valores que se esperan de respuesta, multiplicar cada valor *2
        List<Integer> resultados = IntStream.range(0, 1000).map(n -> n * 2).boxed().collect(Collectors.toList());

        //Stream con código dinámico, toma valores del primer conjunto de datos y aplica la operación *2, verifica resultado obtenido correspondiente a resultados
        return entradas.stream()
                .map(numero -> DynamicTest.dynamicTest("multiplicando: " + numero,
                        () -> {
                            assertEquals(calculadora.multiplica(numero, 2), resultados.get(numero));
                        }));
    }
}