
// Write a simple Lamdba Expression to start a thread and dispaly"Hellow World"message

public static void main(String[] args) {
    new Thread(()->System.out.println("Hello World")).start();    
}



/* Write a program to display the below output 
1
3,5
7,9,11 
13,15,17,19 
21,23,25,27,29
*/
int count=1;

for(int i=1;i<5;i++){
    int j=i;
    while(j-->=0){System.out.print(count);
        System.out.print(",");count+=2;
        System.out.print(count);
    }
}

List<Product>productCategories=new ArrayList<>();
Product product=new Product();
product.setId(100);
product.setCode("Product1");
productCategories.add(product);
product=new Product();product.setId(200);
product.setCode("Product2");
productCategories.add(product);
product=new Product();
product.setId(300);
product.setCode("Product3");
productCategories.add(product);

List<String>codes=new ArrayList<>();
productCategories.stream()
.forEach(it->codes.put(it.getCode()));


// Write a sql query to display the highest and least salary in a single row Table Name:Employee EmpID Salary-----------------1000 100000 2000 300000 3000 200000 4000 300000 5000 600000 6000 100000

// SELECT MIN(Salary),MAX(Salary)from Employee Where EmpID=1000;

// Expose rest end points using Spring RESTFul,Take input as name from request and display as"Welcome %name%"

@RestController
@RequestMapping(value="/test", consumes=MediaType.Application_type_json)
public class MyRestFulController {
    @GetMapping
    public Product getName(TestRequest req) {
        return new Product(req.name);
    }
}
