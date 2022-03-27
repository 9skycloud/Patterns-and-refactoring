package com.skycloud.refactor.builder.simple;

public class NewRobot implements AbstractRobotBuilder {

	@Override
	public void makeHead() {
		//制作头型
		makeHeadStyle();
		//制作眼睛，安装摄像头
		makeEye();
		//制作控制芯片
		makeCpu();
		//制作嘴巴
	}
	
	@Override
	public void makeBody() {
		//制作胸
		makeChest();
		//安装电池
		makeBattery();
		//制作骨骼
		makeBones();
	}
	
	@Override
	public void makeLeg() {
		// TODO Auto-generated method stub
		//制作腿
		makeSingleLeg();
		//制作脚
		makeFoot();
		//制作行走联动装置
		makeLinkPage();
	}

	@Override
	public void makeNose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeMouse() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeCpu() {
		// TODO Auto-generated method stub
		System.out.println("最新CPU");
	}

	@Override
	public void makeEye() {
		// TODO Auto-generated method stub
		System.out.println("一直眼睛");
	}

	@Override
	public void makeHeadStyle() {
		// TODO Auto-generated method stub
		System.out.println("动物型头");
	}

	@Override
	public void makeBones() {
		// TODO Auto-generated method stub
		System.out.println("人形骨骼");
	}

	@Override
	public void makeBattery() {
		// TODO Auto-generated method stub
		System.out.println("高性能电池");
	}

	@Override
	public void makeArms() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeChest() {
		// TODO Auto-generated method stub
		System.out.println("人形胸");
	}


	@Override
	public void makeLinkPage() {
		// TODO Auto-generated method stub
		System.out.println("联合滚动装置");
	}

	@Override
	public void makeToe() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeFoot() {
		// TODO Auto-generated method stub
		System.out.println("双轮子");
	}

	@Override
	public void makeSingleLeg() {
		// TODO Auto-generated method stub
		System.out.println("轮子轴承");
	}

}
