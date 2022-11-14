package lotto.program;

import lotto.utils.Converter;
import lotto.utils.Generator;
import lotto.vo.Lotto;
import lotto.vo.LottoOfAnswer;
import lotto.vo.LottoOfUser;
import lotto.vo.PrizeOfUser;

public class BusinessProgram {

    public LottoOfUser generateUserLotto(int money) {
        int ticket = Converter.moneyToTicket(money);
        return generateLottoByTicket(ticket);
    }

    private LottoOfUser generateLottoByTicket(int ticket) {
        LottoOfUser userOfLotto = new LottoOfUser();
        for (int index = 0; index < ticket; index++) {
            Lotto newLotto = new Lotto(Generator.makeRandomLottoNumbers());
            userOfLotto.add(newLotto);
        }
        return userOfLotto;
    }

    public void printUserLottoResults(LottoOfUser userLotto, LottoOfAnswer answerLotto) {
        System.out.println("당첨통계\t---");
        PrizeOfUser userPrize = userLotto.matchWithAnswer(answerLotto);
    }
}
