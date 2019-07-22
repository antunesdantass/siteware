package unity.discount;

import com.siteware.ecommerce.pojo.product.Product;
import com.siteware.ecommerce.service.discount.Discount;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class DiscountTest {

    private final Double productPrice = 5.0;
    private Product product;

    @Before
    public void setUp() {
        product = new Product();
        product.setPricing(productPrice);
    }

    @Test
    public void testDiscountTresPor10() {
        product.setDiscount(Discount.TRES_POR_10);
        assertThat(product.getPricing(2)).isEqualTo(2 * productPrice);
        assertThat(product.getPricing(3)).isEqualTo(10.0);
        assertThat(product.getPricing(4)).isEqualTo(15.0);
        assertThat(product.getPricing(5)).isEqualTo(20.0);
        assertThat(product.getPricing(6)).isEqualTo(20.0);
    }

    @Test
    public void testDiscountPagueUmLeveDois() {
        product.setDiscount(Discount.PAGUE_UM_LEVE_DOIS);
        assertThat(product.getPricing(1)).isEqualTo(productPrice);
        assertThat(product.getPricing(2)).isEqualTo(productPrice);
        assertThat(product.getPricing(3)).isEqualTo(2 * productPrice);
        assertThat(product.getPricing(4)).isEqualTo(2 * productPrice);
    }

}
