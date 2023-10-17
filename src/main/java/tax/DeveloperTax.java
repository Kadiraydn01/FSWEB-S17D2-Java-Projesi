package tax;

import org.springframework.stereotype.Component;

@Component
public class DeveloperTax implements Taxable{
    @Override
    public double getSimpleTaxRate() {
        return 7;
    }

    @Override
    public double getMiddleTaxRate() {
        return 12;
    }

    @Override
    public double getSeniorTaxRate() {
        return 17;
    }
}
