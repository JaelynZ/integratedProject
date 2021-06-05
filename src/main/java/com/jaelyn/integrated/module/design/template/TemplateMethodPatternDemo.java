package com.jaelyn.integrated.module.design.template;

/**
 * 模板方法模式demo
 *
 * 例子：小明要炒两道菜：炒豆芽和炒茄子；
 * 分析：炒菜都有固定步骤：洗菜，热锅下油，下菜翻炒，下调料，起锅。
 * 由于炒菜流程是固定的，而其中有些步骤对不同的菜而言具备不同的操作，因此可以很好地使用 模板方法模式 完成炒菜过程。
 *
 **/
public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        System.out.println("准备炒豆芽");
        CookVegetable cookVegetable = new CookBeanSprout();
        cookVegetable.cook();

        System.out.println();
        System.out.println("准备炒茄子");
        cookVegetable = new CookEggplant();
        cookVegetable.cook();
    }

    // 抽象模板类：定义炒菜流程
    static abstract class CookVegetable {
        protected void wash() {
            System.out.println("洗菜");
        }

        protected void pourOil() {
            System.out.println("热油下锅");
        }

        protected void fry() {
            System.out.println("下菜翻炒");
        }

        // 具体调料由菜决定
        protected abstract void pourSauce();

        // 具体炒菜流程
        public final void cook() {
            this.wash();
            this.pourOil();
            this.fry();
            this.pourSauce();
            System.out.println("起锅吃菜");
        }
    }

    // 豆芽
    static class CookBeanSprout extends CookVegetable {

        @Override
        protected void pourOil() {
            System.out.println("热锅少油");
        }

        @Override
        protected void fry() {
            System.out.println("快速翻炒");
        }

        @Override
        protected void pourSauce() {
            System.out.println("加盐和少量生抽");
        }
    }

    // 茄子
    static class CookEggplant extends CookVegetable {

        @Override
        protected void wash() {
            System.out.println("去除头尾，然后用水洗下");
        }

        @Override
        protected void pourOil() {
            System.out.println("热锅多油");
        }

        @Override
        protected void pourSauce() {
            System.out.println("加盐和鸡精");
        }
    }
}
