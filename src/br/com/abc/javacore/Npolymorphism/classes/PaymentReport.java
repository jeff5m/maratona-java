package br.com.abc.javacore.Npolymorphism.classes;

public class PaymentReport {
    public void GenericPaymentReport(Employee employee) {
//        Widening casting - Employee is a superclass of Manager and Salesman,
//        so all methods and attributes of these subclass are also in their superclass. But specific methods and
//        and attributes of subclass aren't.
        System.out.println("Gerando relatorio de pagamento...");
        employee.paymentCalculation();
        System.out.println("Nome: " + employee.getName());
        System.out.println("Salario do mes: " + employee.getSalary());
//        prevents classExtension error
        if (employee instanceof Manager) {
//            Narrowing casting - converts the subclass to refer to your superclass. Now the info brought in the argument
//            is passed to the Manager. So we can access the methods and attributes of Employee and Manager as well.
            Manager manager = (Manager) employee;
            System.out.println("Participacao nos lucros: " + manager.getProfitShare());
        }
        if (employee instanceof Salesman) {
//            Another syntax of Narrowing casting
            System.out.println("Total de vendas: " + ((Salesman) employee).getTotalSales());
        }
    }
}
