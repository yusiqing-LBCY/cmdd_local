package cn.com.cmdd.dao;


import org.apache.ibatis.annotations.Param;

import cn.com.cmdd.domain.Printer;

import java.util.List;

public interface PrinterDao {
	void savePrinter(Printer Printer);
	void deletePrinter(@Param("id") Integer id);
	void updatePrinter(Printer Printer);
	List<Printer> getPrinter(
            @Param("shop_id") Integer shop_id,
            @Param("id") Integer id
    );
	Printer getPrinterNameByPrinter_type(
            @Param("shop_id") Integer shop_id,
            @Param("printer_type") Integer printer_type);
}
