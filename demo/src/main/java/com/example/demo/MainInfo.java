package com.example.demo;


public class MainInfo {
         ClientsInfo clientsInfo;
         ExpensesInfo expensesInfo;
         IncomeInfo incomeInfo;
         float CR;
         float ConvR;
         float RetR;
         float Cac;
         float ARPU;
         float LTV;
         float ROI;
         String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientsInfo getClientsInfo() {
            return clientsInfo;
        }

        public void setClientsInfo(ClientsInfo clientsInfo) {
            this.clientsInfo = clientsInfo;
        }

        public ExpensesInfo getExpensesInfo() {
            return expensesInfo;
        }

        public void setExpensesInfo(ExpensesInfo expensesInfo) {
            this.expensesInfo = expensesInfo;
        }

        public IncomeInfo getIncomeInfo() {
            return incomeInfo;
        }

        public void setIncomeInfo(IncomeInfo incomeInfo) {
            this.incomeInfo = incomeInfo;
        }

    @Override
    public String toString() {
        return this.name;
    }

    public float ChurnRate() {
        return ((float) clientsInfo.getLeftClientsNumber() / clientsInfo.getCurrentAmountClients()) * 100;
    }

    public float ConversionRate() {
        return ((float) clientsInfo.getConvertedUsers() / clientsInfo.getVisitors()) * 100;
    }

    public float RetentionRate() {
        return 100 - ChurnRate();
    }

    public float CAC() {
        float totalAcquisitionCost = expensesInfo.getMarketingExpenses() + expensesInfo.getSaleExpenses();
        return totalAcquisitionCost / clientsInfo.getNewClientsNumber();
    }

    public float ARPUCount() {
        return incomeInfo.getAllIncome() / (float) clientsInfo.getCurrentAmountClients();
    }

    public float LTVCount() {
        return ARPUCount() * clientsInfo.getCustomerLifetime(); // период сотрудничества в месяцах
    }


    public float ROI() {
        return ((incomeInfo.getAllIncome() - expensesInfo.getAllExpenses()) / expensesInfo.getAllExpenses()) * 100;
    }
        public void SetCR(){
            this.CR = ChurnRate();
        }
        public void SetConvR(){
            this.ConvR = ConversionRate();
        }
        public void SetRetR(){
            this.RetR = RetentionRate();
        }
        public void SetCAC(){
            this.Cac = CAC();
        }
        public void SetARPU(){
            this.ARPU = ARPUCount();
        }
        public void SetLTV(){
            this.LTV = LTVCount();
        }
        public void SetRoI(){
            this.ROI = ROI();
        }

        public float getCR() {
            return CR;
        }

        public float getConvR() {
            return ConvR;
        }

        public float getRetR() {
            return RetR;
        }

        public float getCac() {
            return Cac;
        }

        public float getARPU() {
            return ARPU;
        }

        public float getLTV() {
            return LTV;
        }

        public float getROI() {
            return ROI;
        }
}
