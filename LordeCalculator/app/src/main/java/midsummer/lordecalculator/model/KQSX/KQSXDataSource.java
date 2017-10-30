package midsummer.lordecalculator.model.KQSX;

import java.util.List;

/**
 * Created by NIENLM on 10/23/17.
 */

public interface KQSXDataSource {
    KQSX getKQSX(long date);
    KQSX getLastestKQSX();
    List<KQSX> getKQSXBetween(long from, long to);
    void setKQSX(List<Integer> data);
    void updateKQSX(final long dt, final List<Integer> data);
}
