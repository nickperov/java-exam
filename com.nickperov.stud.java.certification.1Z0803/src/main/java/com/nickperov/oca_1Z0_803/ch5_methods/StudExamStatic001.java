package com.nickperov.oca_1Z0_803.ch5_methods;

public class StudExamStatic001 {

	public static void main(String[] args) {


		System.out.println("Next tracking num: " + ShippingPackage.nextTrackingNumber);

		System.out.println("Add package");
		ShippingPackage sp = new ShippingPackage();
		System.out.println("Package tracking num: " + sp.getPackageTrackingNumber());
		System.out.println("Next tracking num: " + ShippingPackage.nextTrackingNumber);

		System.out.println("Add package");
		ShippingPackage sp2 = new ShippingPackage();
		System.out.println("Package tracking num: " + sp2.getPackageTrackingNumber());
		System.out.println("Next tracking num: " + ShippingPackage.nextTrackingNumber);
	}

}

class ShippingPackage {
	public static int nextTrackingNumber = 100000;
	private int packageTrackingNumber;

	public ShippingPackage() {
		this.packageTrackingNumber = nextTrackingNumber;
		nextTrackingNumber++;
	}

	public int getPackageTrackingNumber() {
		return packageTrackingNumber;
	}
}