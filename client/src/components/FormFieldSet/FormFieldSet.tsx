import { ReactNode } from "react";
type TProperties = {
    autoFocus: boolean | undefined,
    children: ReactNode | ReactNode[],
    handler: ((e:React.ChangeEvent<HTMLInputElement>) => void) | undefined,
    minLength: number | undefined,
    name: string | undefined,
    normal: boolean | undefined, 
    placeholder: string | undefined,
    required: boolean | undefined,
    type: string | undefined, 
    value: any


}
function FormFieldSet({
    autoFocus = false,
    children = undefined, 
    handler = undefined,
    minLength = undefined,
    name = undefined,
    normal = true,
    placeholder = undefined,
    required = false,
    type = undefined,
    value = undefined,
} : TProperties ) {
    return (
    <fieldset>
        <input
        autoFocus={autoFocus}
        className={`form-control ${normal ? "" : "form-control-lg"}`}
        minLength={minLength}
        name={name}
        onChange={handler}
        placeholder={placeholder}
        required={required}
        type={type}
        value={value}
        />
        {children}
    </fieldset>
    );
};

/* 
  autoFocus,
  children,
  handler,
  minLength,
  name,
  normal,
  placeholder,
  required,
  type,
  value,
*/
export default FormFieldSet;