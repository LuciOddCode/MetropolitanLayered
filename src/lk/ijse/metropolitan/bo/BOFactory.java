package lk.ijse.metropolitan.bo;

import lk.ijse.metropolitan.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CO,CUSTOMER,EMPLOYEE,IR,LOGIN,PRODUCT,RAYPA,RAYPP,SALARY,SIGN_UP,SS,SUPPLIER
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CO:
                return new CheckOutBOImpl();
            case CUSTOMER:
                return new CustomerBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case IR:
                return new IncomeReportBOImpl();
            case LOGIN:
                return new LoginBOImpl();
            case PRODUCT:
                return new ProductBOImpl();
            case RAYPA:
                return new RAYPAppBOImpl();
            case RAYPP:
                return new RAYPPaymentBOImpl();
            case SALARY:
                return new SalaryBOImpl();
            case SIGN_UP:
                return new SignUpBOImpl();
            case SS:
                return new StockSheetBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            default:
                return null;
        }
    }
}
