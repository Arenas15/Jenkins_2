pipeline {
    agent any
    
    stages {
        stage('Mostrar empleados con infracción') {
            steps {
                script {
                    def fileContent = readFile('empleados_con_infraccion.txt')
                    def lines = fileContent.split('\n')
                    
                    for (line in lines) {
                        def employeeInfo = line.split(',')
                        def nombre = employeeInfo[0]
                        def posicion = employeeInfo[1]
                        def descuentoAnual = employeeInfo[2]
                        
                        echo "Empleado: ${nombre}, Posición: ${posicion}, Descuento Anual: ${descuentoAnual}"
                    }
                }
            }
        }
    }
}
