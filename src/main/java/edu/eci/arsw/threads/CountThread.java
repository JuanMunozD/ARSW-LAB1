/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread implements Runnable{

	private int minimo;
	private int maximo;
	
	public CountThread(int ini, int fin) {
		minimo = Math.min(ini, fin);
		maximo = Math.max(ini, fin);
	}
	
	@Override
	public void run() {
		for (int i=minimo; i<=maximo; i++) System.out.println(i);
	}
    
	
}