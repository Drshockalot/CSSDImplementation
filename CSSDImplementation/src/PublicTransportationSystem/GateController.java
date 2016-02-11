/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JoBa
 */
public class GateController {
    private boolean open;
    
    public boolean isOpen()
    {
        return this.open;
    }
    
    public void close()
    {
        this.open = false;
    }
    
    public void open()
    {
        this.open = true;
    }
}
