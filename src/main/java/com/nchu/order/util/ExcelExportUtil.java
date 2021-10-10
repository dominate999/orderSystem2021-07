package com.nchu.order.util;

import com.nchu.order.entity.OrderInfoVO;
import com.nchu.order.entity.OrderItemVO;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelExportUtil {

    private static final long serialVersionUID = 1L;

    /**
     * 设置题头题尾的样式
     * @param workbook
     * @return
     */
    public static CellStyle getStyle(XSSFWorkbook workbook) {
        CellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellstyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));
        Font font = workbook.createFont();//字体
        font.setFontName("宋体");//字体
        font.setFontHeightInPoints((short) 12);//字号
        font.setBold(true);//加粗
        cellstyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());// 设置背景色
        cellstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellstyle.setFont(font);
        setBorderStyle(cellstyle);
        return cellstyle;
    }

    /**
     * 设置标题的样式
     * @param workbook
     * @return
     */
    public static CellStyle getStyletitle(XSSFWorkbook workbook) {//标题格式
        CellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellstyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        Font font = workbook.createFont();//字体
        font.setFontName("宋体");//字体
        font.setFontHeightInPoints((short) 30);//字号
        font.setBold(true);//加粗
        cellstyle.setFont(font);
        setBorderStyle(cellstyle);
        return cellstyle;
    }

    /**
     * 设置表中数据样式
     * @param workbook
     * @return
     */
    public static CellStyle getStyle1(XSSFWorkbook workbook) {
        CellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
        cellstyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
        Font font = workbook.createFont();//字体
        font.setFontName("微软雅黑");//字体
        font.setFontHeightInPoints((short) 12);//字号
        cellstyle.setFont(font);
        setBorderStyle(cellstyle);
        return cellstyle;
    }

    /**
     * 设置边框及颜色
     * @param style
     * @return
     */
    public static void setBorderStyle(CellStyle style) {
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());//下边框为黑色
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());//左边框为黑色
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());//上边框为黑色
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());//右边框为黑色

    }


    /**
     * 表中数据的处理
     * @param orderInfoVOList
     * @param orderItemVOList
     * @return
     */
    public static  XSSFWorkbook getXSSFWorkbook(List<OrderInfoVO> orderInfoVOList, List<OrderItemVO> orderItemVOList) {

        int n = 0;
        int m = 0;
        int sum = 0;
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("sheet1");//设置页名

        XSSFRow row0 = sheet.createRow(0);
        row0.setHeightInPoints(40);
        XSSFCell celltitle = row0.createCell(0);
        celltitle.setCellStyle(getStyletitle(wb));
        celltitle.setCellValue("饿麻了");//标题
        //合并
        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                10 // last column
        );
        sheet.addMergedRegion(region);



        XSSFRow row1 = sheet.createRow(1);
        XSSFCell cellj0 = row1.createCell(0);//设置行的分格
        XSSFCell cellj1 = row1.createCell(1);
        XSSFCell cellj3 = row1.createCell(3);
        XSSFCell cellj4 = row1.createCell(4);
        XSSFCell cellj5 = row1.createCell(5);
        XSSFCell cellj6 = row1.createCell(6);
        XSSFCell cellj7 = row1.createCell(7);
        XSSFCell cellj8 = row1.createCell(8);
        XSSFCell cellj9 = row1.createCell(9);
        XSSFCell cellj10 = row1.createCell(10);
        cellj1.setCellStyle(getStyle(wb));
        cellj3.setCellStyle(getStyle(wb));
        cellj4.setCellStyle(getStyle(wb));
        cellj5.setCellStyle(getStyle(wb));
        cellj6.setCellStyle(getStyle(wb));
        cellj7.setCellStyle(getStyle(wb));
        cellj8.setCellStyle(getStyle(wb));
        cellj9.setCellStyle(getStyle(wb));
        cellj10.setCellStyle(getStyle(wb));

        CellRangeAddress region1 = new CellRangeAddress(1, 1, 0, 1);
        sheet.addMergedRegion(region1);
        cellj0.setCellValue("时间：");
        cellj0.setCellStyle(getStyle(wb));
        XSSFCell cellj2 = row1.createCell(2);
        CellRangeAddress region2 = new CellRangeAddress(1, 1, 2, 10);
        sheet.addMergedRegion(region2);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        cellj2.setCellValue(df.format(new Date()));//获取当前系统时间
        cellj2.setCellStyle(getStyle(wb));

        //行头部标题
        String[] title = {"订单编号", "订单名", "订单时间", "订单状态", "用户姓名", "用户地址", "用户电话", "菜名", "数量", "价格", "总价格"};
        //第一个参数代表列id(从0开始),第2个参数代表宽度值
        sheet.setColumnWidth(1, 4000);
        sheet.setColumnWidth(2, 8000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 3000);
        sheet.setColumnWidth(5, 11000);
        sheet.setColumnWidth(6, 5000);
        sheet.setColumnWidth(7, 6000);
        sheet.setColumnWidth(8, 3000);
        sheet.setColumnWidth(10,3000);
        // 创建一行 及 样式
        XSSFRow row2 = sheet.createRow(2);
        row2.setHeightInPoints(25);
        // 设置一行 数据
        for (int i = 0; i < title.length; i++) {
            // 创建每一列 及 样式
            XSSFCell cell = row2.createCell(i);
            // 设置每一列 数据
            cell.setCellValue(title[i]);
            cell.setCellStyle(getStyle(wb));
        }

        //通过orderItemVOList与orderItemVOList两序列合并成一个序列表
        for (int i = 0; i < orderItemVOList.size(); i++) { //订单详情的序列
            OrderItemVO orderItemVO = orderItemVOList.get(i);
            XSSFRow row = sheet.createRow(i + 3);
            row.setHeightInPoints(20);

            XSSFCell cell0 = row.createCell(0);
            XSSFCell cell1 = row.createCell(1);
            XSSFCell cell2 = row.createCell(2);
            XSSFCell cell3 = row.createCell(3);
            XSSFCell cell4 = row.createCell(4);
            XSSFCell cell5 = row.createCell(5);
            XSSFCell cell6 = row.createCell(6);
            XSSFCell cell7 = row.createCell(7);
            XSSFCell cell8 = row.createCell(8);
            XSSFCell cell9 = row.createCell(9);
            XSSFCell cell10 = row.createCell(10);
            cell0.setCellStyle(getStyle1(wb));
            cell1.setCellStyle(getStyle1(wb));
            cell2.setCellStyle(getStyle1(wb));
            cell3.setCellStyle(getStyle1(wb));
            cell4.setCellStyle(getStyle1(wb));
            cell5.setCellStyle(getStyle1(wb));
            cell6.setCellStyle(getStyle1(wb));
            cell7.setCellStyle(getStyle1(wb));
            cell8.setCellStyle(getStyle1(wb));
            cell9.setCellStyle(getStyle1(wb));
            cell10.setCellStyle(getStyle1(wb));

            if (i + 1 < orderItemVOList.size()) {
                if (orderItemVO.getOrder_id() == orderItemVOList.get(i + 1).getOrder_id()) {//判断下一个id是否相等
                    m = 1;//为后面结算判断
                    n++;//为合并判断
                    if((n != 0) && (i + 1 == orderItemVOList.size() - 1)){//最后几行可合并得进行合并
                        CellRangeAddress region3 = new CellRangeAddress(i + 3, i + 3 + n, 0, 0);
                        sheet.addMergedRegion(region3);
                        CellRangeAddress region4 = new CellRangeAddress(i + 3, i + 3 + n, 1, 1);
                        sheet.addMergedRegion(region4);
                        CellRangeAddress region5 = new CellRangeAddress(i + 3, i + 3 + n, 2, 2);
                        sheet.addMergedRegion(region5);
                        CellRangeAddress region6 = new CellRangeAddress(i + 3, i + 3 + n, 3, 3);
                        sheet.addMergedRegion(region6);
                        CellRangeAddress region7 = new CellRangeAddress(i + 3, i + 3 + n, 4, 4);
                        sheet.addMergedRegion(region7);
                        CellRangeAddress region8 = new CellRangeAddress(i + 3, i + 3 + n, 5, 5);
                        sheet.addMergedRegion(region8);
                        CellRangeAddress region9 = new CellRangeAddress(i + 3, i + 3 + n, 10, 10);
                        sheet.addMergedRegion(region9);
                        CellRangeAddress region10 = new CellRangeAddress(i + 3, i + 3 + n, 6, 6);
                        sheet.addMergedRegion(region10);
                    }
                }else{
                    m = 0;
                    if(n != 0){//前面中间可合并得进行合并
                        CellRangeAddress region3 = new CellRangeAddress(i + 3 - n, i + 3, 0, 0);
                        sheet.addMergedRegion(region3);
                        CellRangeAddress region4 = new CellRangeAddress(i + 3 - n, i + 3, 1, 1);
                        sheet.addMergedRegion(region4);
                        CellRangeAddress region5 = new CellRangeAddress(i + 3 - n, i + 3, 2, 2);
                        sheet.addMergedRegion(region5);
                        CellRangeAddress region6 = new CellRangeAddress(i + 3 - n, i + 3, 3, 3);
                        sheet.addMergedRegion(region6);
                        CellRangeAddress region7 = new CellRangeAddress(i + 3 - n, i + 3, 4, 4);
                        sheet.addMergedRegion(region7);
                        CellRangeAddress region8 = new CellRangeAddress(i + 3 - n, i + 3, 5, 5);
                        sheet.addMergedRegion(region8);
                        CellRangeAddress region9 = new CellRangeAddress(i + 3 - n, i + 3, 10, 10);
                        sheet.addMergedRegion(region9);
                        CellRangeAddress region10 = new CellRangeAddress(i + 3 - n, i + 3, 6, 6);
                        sheet.addMergedRegion(region10);
                    }
                    n = 0;
                }
            }
            //订单的序列
            for (int j = 0; j < orderInfoVOList.size(); j++) {
                OrderInfoVO order = orderInfoVOList.get(j);
                if (orderItemVO.getOrder_id() == order.getOrder_id()) {//判断订单id与订单详情id是否相等
                    cell0.setCellValue(order.getOrder_id());
                    cell1.setCellValue(order.getOrder_name());
                    cell2.setCellValue(order.getOrder_time());
                    cell3.setCellValue(order.getOrder_status());
                    cell4.setCellValue(order.getUser_name());
                    cell5.setCellValue(order.getUser_addressed());
                    cell6.setCellValue(order.getUser_phone());
                    cell7.setCellValue(orderItemVO.getDishes_name());
                    cell8.setCellValue(orderItemVO.getOrderitem_number());
                    cell9.setCellValue(orderItemVO.getOrderitem_money());
                    if (order.getOrder_status().equals("已完成")) {//判断订单状态是否“已完成”，累加计算总和
                        cell10.setCellValue(order.getOrder_money());
                        if(m == 0) {
                            sum += Integer.parseInt(order.getOrder_money());
                        }
                    }

                }
            }
        }
        XSSFRow rowend = sheet.createRow(orderItemVOList.size() + 3);
        rowend.setHeightInPoints(20);

        XSSFCell cellend0 = rowend.createCell(0);
        cellend0.setCellValue("总计：");
        cellend0.setCellStyle(getStyle(wb));

        XSSFCell cellend1 = rowend.createCell(1);
        CellRangeAddress regionend1 = new CellRangeAddress(orderItemVOList.size() + 3, orderItemVOList.size() + 3, 1, 9);
        sheet.addMergedRegion(regionend1);
        cellend1.setCellValue("收入：");
        cellend1.setCellStyle(getStyle(wb));

        XSSFCell cellend2 = rowend.createCell(2);
        XSSFCell cellend3 = rowend.createCell(3);
        XSSFCell cellend4 = rowend.createCell(4);
        XSSFCell cellend5 = rowend.createCell(5);
        XSSFCell cellend6 = rowend.createCell(6);
        XSSFCell cellend7 = rowend.createCell(7);
        XSSFCell cellend8 = rowend.createCell(8);
        XSSFCell cellend9 = rowend.createCell(9);
        cellend2.setCellStyle(getStyle(wb));
        cellend3.setCellStyle(getStyle(wb));
        cellend4.setCellStyle(getStyle(wb));
        cellend5.setCellStyle(getStyle(wb));
        cellend6.setCellStyle(getStyle(wb));
        cellend7.setCellStyle(getStyle(wb));
        cellend8.setCellStyle(getStyle(wb));
        cellend9.setCellStyle(getStyle(wb));

        XSSFCell cellend10 = rowend.createCell(10);
        cellend10.setCellValue(sum+"");
        cellend10.setCellStyle(getStyle(wb));
        return wb;
    }


}

