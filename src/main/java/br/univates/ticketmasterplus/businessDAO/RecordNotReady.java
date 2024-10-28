/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.ticketmasterplus.businessDAO;

/**
 *
 * @author mouriac
 */
public class RecordNotReady extends Exception
{

    public RecordNotReady()
    {
    }

    public RecordNotReady(String message)
    {
        super(message);
    }
    
}
