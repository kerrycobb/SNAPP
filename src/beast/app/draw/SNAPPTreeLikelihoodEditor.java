package beast.app.draw;

import java.util.List;

import javax.swing.Box;
import beast.core.Input;
import beast.core.Plugin;
import snap.likelihood.SnAPTreeLikelihood;

public class SNAPPTreeLikelihoodEditor extends ListInputEditor {
    private static final long serialVersionUID = 1L;

    public Class<?> baseType() {
        return SnAPTreeLikelihood.class;
    }
    
    @Override
    public void init(Input<?> input, Plugin plugin, EXPAND bExpand, boolean bAddButtons) {
		m_bAddButtons = bAddButtons;
    	m_bExpand = bExpand;
        m_input = input;
        m_plugin = plugin;

        m_listBox = Box.createVerticalBox();
        // list of inputs 
        for (Object o : (List<?>) input.get()) {
            if (o instanceof SnAPTreeLikelihood) {
            	SnAPTreeLikelihood plugin2 = (SnAPTreeLikelihood) o;
            	Plugin substModel = plugin2.m_pSiteModel.get().m_pSubstModel.get();
            	PluginPanel.addInputs(m_listBox, substModel, this, null);
            	PluginPanel.addInputs(m_listBox, plugin2, this, null);
            }
        }
		add(m_listBox);
        updateState();
    }

}