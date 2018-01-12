package examplemod.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Test1 extends AbstractCard {
    public static final String ID = "Test1";
    public static final String NAME = "Test Card";
    public static final String IMAGE = "status/beta";
    public static final int COST = 0;
    public static final String DESCRIPTION = "DEBUG";
    public static final String UPGRADED_DESCRIPTION = "DEBUG";
    public static final AbstractCard.CardType TYPE = AbstractCard.CardType.SKILL;
    public static final AbstractCard.CardColor COLOR = AbstractCard.CardColor.RED;
    public static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.BASIC;
    public static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.SELF;
    public static final int POOL = 0;
    
    public static final int DRAW = 1;
    public static final boolean EXHAUST = true;
    
    public Test1() {
        super(ID, NAME, IMAGE, IMAGE, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET, POOL);

        this.baseMagicNumber = DRAW;
        this.magicNumber = baseMagicNumber;
        
        this.exhaust = EXHAUST;
    }
    
    public void use(final AbstractPlayer p, final AbstractMonster m) {
        multiDamage = new int[AbstractDungeon.getCurrRoom().monsters.monsters.size()];
        for (int i = 0; i < AbstractDungeon.getCurrRoom().monsters.monsters.size(); ++i) {
            this.multiDamage[i] = 250;
        }
        AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(p, multiDamage, damageTypeForTurn, AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
    
    public AbstractCard makeCopy() {
        return new Test1();
    }
    
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = UPGRADED_DESCRIPTION;
            this.initializeDescription();
            
            this.upgradeMagicNumber(1);
        }
    }
}
